// server.js
require('dotenv').config();
const express = require('express');
const axios = require('axios');
const cors = require('cors');

const app = express();
const PORT = 3000;

// Allow CORS for frontend
app.use(cors());

const API_KEY = process.env.OPENWEATHER_API_KEY;

// Get weather forecast for a city
app.get('/api/weather', async (req, res) => {
  const { city } = req.query;
  if (!city) return res.status(400).json({ error: 'City is required' });

  try {
    const url = `https://api.openweathermap.org/data/2.5/forecast?q=${encodeURIComponent(city)}&units=metric&appid=${API_KEY}`;
    const response = await axios.get(url);

    const groupedByDate = {};

    response.data.list.forEach(entry => {
      const date = entry.dt_txt.split(' ')[0];
      if (!groupedByDate[date]) groupedByDate[date] = [];
      groupedByDate[date].push(entry.main.temp);
    });

    // Calculate avg temp per day
    const dailyForecast = Object.entries(groupedByDate).map(([date, temps]) => {
      const avg = temps.reduce((a, b) => a + b, 0) / temps.length;
      return { date, avgTemp: parseFloat(avg.toFixed(1)) };
    });

    res.json({ city: response.data.city.name, forecast: dailyForecast });
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Failed to fetch weather data' });
  }
});

app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});
