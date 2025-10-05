<template>
  <div class="container py-4">
    <div class="row">
      <div class="col-lg-8 mx-auto">
        <div class="d-flex align-items-center mb-4">
          <i class="bi bi-people-fill text-primary fs-1 me-3"></i>
          <div>
            <h1 class="mb-1">Сторінка користувачів</h1>
            <p class="text-muted mb-0">Тестування API ендпоінту /users</p>
          </div>
        </div>

        <div class="card">
          <div class="card-body">
            <h5 class="card-title">
              <i class="bi bi-cloud-download me-2"></i>
              Завантаження даних
            </h5>
            
            <div class="d-grid gap-2">
              <button 
                @click="load" 
                class="btn btn-primary"
                :disabled="loading"
              >
                <span v-if="loading" class="spinner-border spinner-border-sm me-2"></span>
                <i v-else class="bi bi-arrow-clockwise me-2"></i>
                {{ loading ? 'Завантаження...' : 'Завантажити дані' }}
              </button>
            </div>

            <!-- Індикатор завантаження -->
            <div v-if="loading" class="mt-3">
              <div class="progress">
                <div 
                  class="progress-bar progress-bar-striped progress-bar-animated" 
                  role="progressbar" 
                  style="width: 100%"
                ></div>
              </div>
            </div>

            <!-- Результат -->
            <div v-if="data && !loading" class="mt-3">
              <h6 class="text-success">
                <i class="bi bi-check-circle me-2"></i>
                Дані успішно завантажені!
              </h6>
              <div class="alert alert-success">
                <strong>Відповідь сервера:</strong>
                <pre class="mb-0 mt-2">{{ data }}</pre>
              </div>
            </div>

            <!-- Помилка -->
            <div v-if="error" class="mt-3">
              <div class="alert alert-danger">
                <h6 class="alert-heading">
                  <i class="bi bi-exclamation-triangle me-2"></i>
                  Помилка завантаження
                </h6>
                <p class="mb-0">{{ error }}</p>
                <button @click="clearError" class="btn btn-outline-danger btn-sm mt-2">
                  <i class="bi bi-x-circle me-1"></i>
                  Закрити
                </button>
              </div>
            </div>

            <!-- Інформація про ендпоінт -->
            <div class="mt-4 p-3 bg-light rounded">
              <h6 class="mb-2">
                <i class="bi bi-info-circle me-2"></i>
                Інформація про ендпоінт
              </h6>
              <ul class="mb-0 small">
                <li><strong>URL:</strong> <code>GET /users</code></li>
                <li><strong>Призначення:</strong> Отримання даних користувачів</li>
                <li><strong>Авторизація:</strong> Потрібна роль "User"</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import http from '../services/http';

export default {
  name: 'UsersPage',
  data() {
    return { 
      data: null, 
      error: null,
      loading: false
    };
  },
  methods: {
    async load() {
      this.error = null;
      this.data = null;
      this.loading = true;
      
      try {
        console.log('Завантаження даних з /users...');
        const res = await http.get('/users', { headers: { 'Accept': 'application/json' }});
        this.data = typeof res.data === 'string' ? res.data : JSON.stringify(res.data, null, 2);
        console.log('Дані завантажені:', res.data);
      } catch (e) {
        console.error('Помилка завантаження:', e);
        this.error = e?.response?.status ? `${e.response.status} ${e.response.statusText}` : e.message;
      } finally {
        this.loading = false;
      }
    },
    clearError() {
      this.error = null;
    },
  },
};
</script>

<style scoped>
.card {
  box-shadow: 0 0.125rem 0.25rem rgba(0, 0, 0, 0.075);
  border: 1px solid rgba(0, 0, 0, 0.125);
}

.progress {
  height: 0.5rem;
}

pre {
  background-color: #f8f9fa;
  border: 1px solid #e9ecef;
  border-radius: 0.375rem;
  padding: 1rem;
  font-size: 0.875rem;
  max-height: 300px;
  overflow-y: auto;
}
</style>


