<template>
  <div class="container py-4">
    <h2 class="mb-3">Admin Page</h2>
    <button class="btn btn-secondary mb-3" @click="load">Завантажити дані</button>
    <pre v-if="data">{{ data }}</pre>
    <div v-if="error" class="alert alert-danger">{{ error }}</div>
  </div>
  </template>

<script>
import http from '../services/http';

export default {
  name: 'AdminPage',
  data() {
    return { data: null, error: null };
  },
  methods: {
    async load() {
      this.error = null;
      this.data = null;
      try {
        const res = await http.get('/admin', { headers: { 'Accept': 'application/json' }});
        this.data = JSON.stringify(res.data, null, 2);
      } catch (e) {
        this.error = e?.response?.status ? `${e.response.status} ${e.response.statusText}` : e.message;
      }
    },
  },
};
</script>


