<template>
  <div class="container py-4">
    <!-- Героїчний блок -->
    <div class="row justify-content-center mb-5">
      <div class="col-lg-10 text-center">
        <div class="hero-section bg-primary bg-gradient text-white rounded-3 p-5 mb-4">
          <h1 class="display-4 fw-bold mb-3">
            <i class="bi bi-truck-front me-3"></i>
            Ласкаво просимо до Autobase!
          </h1>
          <p class="lead mb-4">
            Сучасна система управління автопарком з використанням Spring WebFlux та Vue.js
          </p>
          <div class="d-flex gap-3 justify-content-center">
            <router-link to="/users" class="btn btn-light btn-lg">
              <i class="bi bi-people me-2"></i>
              Користувачі
            </router-link>
            <router-link to="/admin" class="btn btn-outline-light btn-lg">
              <i class="bi bi-gear me-2"></i>
              Адмін панель
            </router-link>
          </div>
        </div>
      </div>
    </div>

    <!-- Карточки функціоналу -->
    <div class="row g-4 mb-5">
      <div class="col-md-4">
        <div class="card h-100 shadow-sm">
          <div class="card-body text-center">
            <i class="bi bi-lightning-charge-fill text-warning fs-1 mb-3"></i>
            <h5 class="card-title">Реактивне програмування</h5>
            <p class="card-text">
              Spring WebFlux забезпечує високу продуктивність та масштабованість
            </p>
          </div>
        </div>
      </div>
      
      <div class="col-md-4">
        <div class="card h-100 shadow-sm">
          <div class="card-body text-center">
            <i class="bi bi-database-fill text-success fs-1 mb-3"></i>
            <h5 class="card-title">R2DBC та PostgreSQL</h5>
            <p class="card-text">
              Асинхронна робота з базою даних без блокуючих операцій
            </p>
          </div>
        </div>
      </div>
      
      <div class="col-md-4">
        <div class="card h-100 shadow-sm">
          <div class="card-body text-center">
            <i class="bi bi-shield-lock-fill text-danger fs-1 mb-3"></i>
            <h5 class="card-title">Безпека</h5>
            <p class="card-text">
              Spring Security WebFlux для захисту додатку
            </p>
          </div>
        </div>
      </div>
    </div>

    <!-- Статистика -->
    <div class="row g-4">
      <div class="col-md-3">
        <div class="card border-primary">
          <div class="card-body text-center">
            <h3 class="text-primary mb-1">4</h3>
            <p class="card-text small mb-0">Основні сторінки</p>
          </div>
        </div>
      </div>
      
      <div class="col-md-3">
        <div class="card border-success">
          <div class="card-body text-center">
            <h3 class="text-success mb-1">3</h3>
            <p class="card-text small mb-0">API ендпоінти</p>
          </div>
        </div>
      </div>
      
      <div class="col-md-3">
        <div class="card border-warning">
          <div class="card-body text-center">
            <h3 class="text-warning mb-1">2</h3>
            <p class="card-text small mb-0">Ролі користувачів</p>
          </div>
        </div>
      </div>
      
      <div class="col-md-3">
        <div class="card border-info">
          <div class="card-body text-center">
            <h3 class="text-info mb-1">1</h3>
            <p class="card-text small mb-0">База даних</p>
          </div>
        </div>
      </div>
    </div>

    <!-- Додаткова інформація -->
    <div class="row mt-5">
      <div class="col-lg-8 mx-auto">
        <div class="alert alert-info">
          <h6 class="alert-heading">
            <i class="bi bi-info-circle me-2"></i>
            Про цей додаток
          </h6>
          <p class="mb-2">
            Це демонстраційний проект для вивчення сучасних веб-технологій:
          </p>
          <ul class="mb-0">
            <li><strong>Backend:</strong> Spring Boot 3, WebFlux, R2DBC, PostgreSQL, Spring Security</li>
            <li><strong>Frontend:</strong> Vue 3, Vue Router, Bootstrap 5, Axios</li>
            <li><strong>Інструменти:</strong> Maven, Flyway, Lombok</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HomePage',
  mounted() {
    // Логування для демонстрації
    console.log('Головна сторінка завантажена');
  },
};
</script>

<style scoped>
.hero-section {
  background: linear-gradient(135deg, #0d6efd 0%, #6610f2 100%);
}

.card {
  transition: transform 0.2s ease, box-shadow 0.2s ease;
}

.card:hover {
  transform: translateY(-5px);
  box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15) !important;
}

.btn {
  transition: all 0.2s ease;
}

.btn:hover {
  transform: translateY(-1px);
}
</style>


