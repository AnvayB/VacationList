const form = document.getElementById('tripForm');
const weatherOutput = document.getElementById('weatherOutput');
const packingOutput = document.getElementById('packingOutput');

form.addEventListener('submit', async (e) => {
  e.preventDefault();
  weatherOutput.innerHTML = '';
  packingOutput.innerHTML = '';

  const city = document.getElementById('city').value;
  const start = new Date(document.getElementById('startDate').value);
  const end = new Date(document.getElementById('endDate').value);
  const days = Math.ceil((end - start) / (1000 * 60 * 60 * 24)) + 1;

  if (isNaN(days) || days <= 0) {
    alert('Invalid date range.');
    return;
  }

  const res = await fetch(`http://localhost:3000/api/weather?city=${encodeURIComponent(city)}`);
  const data = await res.json();

  if (data.error) {
    weatherOutput.innerHTML = `<p class="text-red-600 font-semibold">${data.error}</p>`;
    return;
  }

  // Filter forecast to relevant date range
  const forecast = data.forecast.filter(day => {
    const date = new Date(day.date);
    return date >= start && date <= end;
  });

  renderWeather(forecast);
  const packingList = generatePackingList(days, forecast);
  renderPackingList(packingList);
});

function renderWeather(forecast) {
  const section = document.createElement('div');
  section.className = 'bg-white p-4 rounded shadow';

  section.innerHTML = `<h2 class="text-xl font-bold mb-2">Weather Forecast</h2>
    <ul class="list-disc pl-5 space-y-1">
      ${forecast.map(day => `<li>${day.date}: ${day.avgTemp} °C</li>`).join('')}
    </ul>`;

  weatherOutput.appendChild(section);
}

function generatePackingList(days, forecast) {
  const list = {
    Underwear: days,
    Socks: days,
    Shirts: days,
    Pants: Math.ceil(days / 2),
    Shoes: 1,
    Pajamas: 1,
    toiletries: 1
  };

  const cold = forecast.some(day => day.avgTemp < 15);
  if (cold) {
    list.jacket = 1;
    list.hat = 1;
    list.gloves = 1;
  }

  if (days > 5) {
    list["laundry detergent"] = 1;
  }

  return list;
}

function renderPackingList(list) {
  const section = document.createElement('div');
  section.className = 'bg-white p-4 rounded shadow';

  section.innerHTML = `
    <h2 class="text-xl font-bold mb-2">Packing List</h2>
    <ul id="packingList" class="space-y-2"></ul>
    <div class="flex gap-2 mt-4">
      <input type="text" id="newItemName" placeholder="Item name" class="border p-2 rounded w-1/2"/>
      <input type="number" id="newItemQty" placeholder="Qty" class="border p-2 rounded w-1/4"/>
      <button class="bg-green-600 text-white px-3 py-2 rounded" onclick="addItem()">Add Item</button>
    </div>
    <button id="exportXLSXBtn" class="bg-blue-600 text-white px-3 py-2 rounded mt-4">Export as XLSX</button>
  `;

  packingOutput.appendChild(section);
  updatePackingList(list);

  // Add export event listener
  document.getElementById('exportXLSXBtn').onclick = exportPackingListToXLSX;
}

function updatePackingList(items) {
  const listEl = document.getElementById('packingList');
  listEl.innerHTML = '';

  Object.entries(items).forEach(([name, qty]) => {
    const li = document.createElement('li');
    li.className = 'flex justify-between items-center';

    li.innerHTML = `
      <span><strong>${name}</strong>: ${qty}</span>
      <div class="space-x-2">
        <button onclick="editItem('${name}')" class="text-blue-600 hover:underline">Edit</button>
        <button onclick="deleteItem('${name}')" class="text-red-600 hover:underline">Delete</button>
      </div>
    `;

    listEl.appendChild(li);
  });

  window.currentPackingList = items;
}

function addItem() {
  const name = document.getElementById('newItemName').value.trim();
  const qty = parseInt(document.getElementById('newItemQty').value.trim());

  if (!name || isNaN(qty) || qty < 1) return alert('Enter valid item name and quantity');

  window.currentPackingList[name] = qty;
  updatePackingList(window.currentPackingList);
}

function editItem(name) {
  const newQty = prompt(`Enter new quantity for "${name}":`, window.currentPackingList[name]);
  const qty = parseInt(newQty);
  if (!isNaN(qty) && qty > 0) {
    window.currentPackingList[name] = qty;
    updatePackingList(window.currentPackingList);
  }
}

function deleteItem(name) {
  if (confirm(`Remove "${name}" from the list?`)) {
    delete window.currentPackingList[name];
    updatePackingList(window.currentPackingList);
  }
}

function exportPackingListToXLSX() {
  if (!window.currentPackingList || Object.keys(window.currentPackingList).length === 0) {
    alert('Packing list is empty!');
    return;
  }
  // Convert packing list to array of arrays for SheetJS
  const data = [['Item', 'Quantity']].concat(
    Object.entries(window.currentPackingList).map(([name, qty]) => [name, qty])
  );
  const ws = XLSX.utils.aoa_to_sheet(data);
  const wb = XLSX.utils.book_new();
  XLSX.utils.book_append_sheet(wb, ws, 'Packing List');
  XLSX.writeFile(wb, 'packing-list.xlsx');
}
