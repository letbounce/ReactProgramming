<template>
  <div class="container py-4">
    <div class="row justify-content-center">
      <div class="col-lg-8">
        <h1 class="mb-4">
          <i class="bi bi-info-circle text-primary me-2"></i>
          Про наш застосунок
        </h1>
        
        <div class="card mb-4">
          <div class="card-body">
            <h5 class="card-title">
              <i class="bi bi-truck-front text-success me-2"></i>
              Autobase - Система управління автопарком
            </h5>
            <p class="card-text">
              Це демонстраційний застосунок, створений для вивчення Spring WebFlux та Vue.js.
              Система дозволяє управляти автопарком, водіями та заявками на поїздки.
            </p>
          </div>
        </div>

        <div class="row">
          <div class="col-md-6 mb-3">
            <div class="card h-100">
              <div class="card-body text-center">
                <i class="bi bi-gear-fill text-info fs-1 mb-3"></i>
                <h6 class="card-title">Backend</h6>
                <p class="card-text small">
                  Spring Boot 3, WebFlux, R2DBC, PostgreSQL, Spring Security
                </p>
              </div>
            </div>
          </div>
          
          <div class="col-md-6 mb-3">
            <div class="card h-100">
              <div class="card-body text-center">
                <i class="bi bi-palette-fill text-warning fs-1 mb-3"></i>
                <h6 class="card-title">Frontend</h6>
                <p class="card-text small">
                  Vue 3, Vue Router, Bootstrap 5, Axios
                </p>
              </div>
            </div>
          </div>
        </div>

        <div class="alert alert-info mt-4">
          <h6 class="alert-heading">
            <i class="bi bi-lightbulb me-2"></i>
            Функціонал
          </h6>
          <ul class="mb-0">
            <li>Реактивне програмування з Spring WebFlux</li>
            <li>Робота з PostgreSQL через R2DBC</li>
            <li>Безпека з Spring Security</li>
            <li>Сучасний UI з Vue 3 та Bootstrap</li>
            <li>Міграції бази даних з Flyway</li>
          </ul>
        </div>

        <div class="text-center mt-4">
          <router-link to="/" class="btn btn-primary me-2">
            <i class="bi bi-house me-1"></i>
            На головну
          </router-link>
          <router-link to="/users" class="btn btn-outline-primary">
            <i class="bi bi-people me-1"></i>
            Користувачі
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AboutPage',
  mounted() {
    // Додаткова логіка при завантаженні сторінки
    console.log('Сторінка "Про нас" завантажена');
  },
};
</script>

<style scoped>
.card {
  transition: transform 0.2s ease;
}

.card:hover {
  transform: translateY(-2px);
}

.alert {
  border-left: 4px solid #0dcaf0;
}
</style>
