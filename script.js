// Global variables
let currentPlayerId = null;
let currentContractId = null;
let currentVehicleId = null;
let currentRouteId = null;
let currentDriverId = null;

// Player Management Functions
function searchPlayers() {
    const searchTerm = document.getElementById('playerSearch').value.toLowerCase();
    const table = document.getElementById('playersTable');
    const rows = table.getElementsByTagName('tr');
    
    for (let i = 0; i < rows.length; i++) {
        const cells = rows[i].getElementsByTagName('td');
        let found = false;
        
        for (let j = 0; j < cells.length; j++) {
            if (cells[j].textContent.toLowerCase().includes(searchTerm)) {
                found = true;
                break;
            }
        }
        
        rows[i].style.display = found ? '' : 'none';
    }
}

function openAddPlayerModal() {
    document.getElementById('addPlayerModal').style.display = 'block';
}

function closeAddPlayerModal() {
    document.getElementById('addPlayerModal').style.display = 'none';
    document.getElementById('addPlayerForm').reset();
}

function viewPlayer(playerId) {
    currentPlayerId = playerId;
    const modal = document.getElementById('viewPlayerModal');
    const details = document.getElementById('playerDetails');
    
    // Mock player data
    const playerData = {
        1: {
            name: 'Олексій Костюк',
            nickname: 'S1mple',
            age: 26,
            role: 'AWPer',
            kda: 1.35,
            winrate: '87%',
            email: 's1mple@navi.gg',
            phone: '+380501234567',
            status: 'Активний',
            joinDate: '01.01.2020',
            totalMatches: 1247,
            totalHours: 3240
        },
        2: {
            name: 'Denis Sharipov',
            nickname: 'electronic',
            age: 25,
            role: 'Rifler',
            kda: 1.28,
            winrate: '82%',
            email: 'electronic@navi.gg',
            phone: '+380501234568',
            status: 'Активний',
            joinDate: '15.03.2020',
            totalMatches: 1156,
            totalHours: 2980
        }
    };
    
    const player = playerData[playerId] || playerData[1];
    
    details.innerHTML = `
        <div style="display: grid; grid-template-columns: 1fr 1fr; gap: 2rem;">
            <div>
                <h4>Особисті дані</h4>
                <p><strong>Повне ім'я:</strong> ${player.name}</p>
                <p><strong>Нікнейм:</strong> ${player.nickname}</p>
                <p><strong>Вік:</strong> ${player.age}</p>
                <p><strong>Роль:</strong> ${player.role}</p>
                <p><strong>Email:</strong> ${player.email}</p>
                <p><strong>Телефон:</strong> ${player.phone}</p>
                <p><strong>Статус:</strong> <span class="status-badge status-active">${player.status}</span></p>
            </div>
            <div>
                <h4>Статистика</h4>
                <p><strong>KDA:</strong> ${player.kda}</p>
                <p><strong>Виграшність:</strong> ${player.winrate}</p>
                <p><strong>Дата приєднання:</strong> ${player.joinDate}</p>
                <p><strong>Всього матчів:</strong> ${player.totalMatches}</p>
                <p><strong>Всього годин:</strong> ${player.totalHours}</p>
            </div>
        </div>
        <div style="margin-top: 2rem; display: flex; gap: 1rem; justify-content: flex-end;">
            <button class="btn btn-warning" onclick="editPlayer(${playerId})">Редагувати</button>
            <button class="btn" onclick="closeViewPlayerModal()" style="background: #6c757d; color: white;">Закрити</button>
        </div>
    `;
    
    modal.style.display = 'block';
}

function closeViewPlayerModal() {
    document.getElementById('viewPlayerModal').style.display = 'none';
}

function editPlayer(playerId) {
    alert(`Редагування гравця з ID: ${playerId}`);
    closeViewPlayerModal();
}

function deletePlayer(playerId) {
    if (confirm('Ви впевнені, що хочете видалити цього гравця?')) {
        alert(`Гравець з ID: ${playerId} видалений`);
        // Here would be actual deletion logic
    }
}

// Contract Management Functions
function searchContracts() {
    const searchTerm = document.getElementById('contractSearch').value.toLowerCase();
    const table = document.getElementById('contractsTable');
    const rows = table.getElementsByTagName('tr');
    
    for (let i = 0; i < rows.length; i++) {
        const cells = rows[i].getElementsByTagName('td');
        let found = false;
        
        for (let j = 0; j < cells.length; j++) {
            if (cells[j].textContent.toLowerCase().includes(searchTerm)) {
                found = true;
                break;
            }
        }
        
        rows[i].style.display = found ? '' : 'none';
    }
}

function openAddContractModal() {
    document.getElementById('addContractModal').style.display = 'block';
}

function closeAddContractModal() {
    document.getElementById('addContractModal').style.display = 'none';
    document.getElementById('addContractForm').reset();
}

function viewContract(contractId) {
    currentContractId = contractId;
    const modal = document.getElementById('viewContractModal');
    const details = document.getElementById('contractDetails');
    
    // Mock contract data
    const contractData = {
        1: {
            id: 'CT001',
            player: 'S1mple',
            type: 'Основний',
            startDate: '01.01.2024',
            endDate: '31.12.2025',
            salary: '$50,000/міс',
            bonus: '$5,000 за перемогу',
            status: 'Активний',
            terms: 'Повний контракт з усіма правами та обов\'язками'
        },
        2: {
            id: 'CT002',
            player: 'electronic',
            type: 'Основний',
            startDate: '15.03.2024',
            endDate: '14.03.2026',
            salary: '$45,000/міс',
            bonus: '$4,000 за перемогу',
            status: 'Активний',
            terms: 'Стандартний контракт з можливістю продовження'
        }
    };
    
    const contract = contractData[contractId] || contractData[1];
    
    details.innerHTML = `
        <div style="display: grid; grid-template-columns: 1fr 1fr; gap: 2rem;">
            <div>
                <h4>Основна інформація</h4>
                <p><strong>ID контракту:</strong> ${contract.id}</p>
                <p><strong>Гравець:</strong> ${contract.player}</p>
                <p><strong>Тип:</strong> ${contract.type}</p>
                <p><strong>Дата початку:</strong> ${contract.startDate}</p>
                <p><strong>Дата закінчення:</strong> ${contract.endDate}</p>
                <p><strong>Статус:</strong> <span class="status-badge status-active">${contract.status}</span></p>
            </div>
            <div>
                <h4>Фінансові умови</h4>
                <p><strong>Зарплата:</strong> ${contract.salary}</p>
                <p><strong>Бонус:</strong> ${contract.bonus}</p>
                <p><strong>Додаткові умови:</strong></p>
                <p style="background: #f8f9fa; padding: 1rem; border-radius: 5px; margin-top: 0.5rem;">${contract.terms}</p>
            </div>
        </div>
        <div style="margin-top: 2rem; display: flex; gap: 1rem; justify-content: flex-end;">
            <button class="btn btn-warning" onclick="editContract(${contractId})">Редагувати</button>
            <button class="btn btn-success" onclick="renewContract(${contractId})">Продовжити</button>
            <button class="btn" onclick="closeViewContractModal()" style="background: #6c757d; color: white;">Закрити</button>
        </div>
    `;
    
    modal.style.display = 'block';
}

function closeViewContractModal() {
    document.getElementById('viewContractModal').style.display = 'none';
}

function editContract(contractId) {
    alert(`Редагування контракту з ID: ${contractId}`);
    closeViewContractModal();
}

function renewContract(contractId) {
    if (confirm('Ви хочете продовжити цей контракт?')) {
        alert(`Контракт з ID: ${contractId} продовжено`);
        // Here would be actual renewal logic
    }
}

// Analytics Functions
function generateReport() {
    alert('Звіт згенеровано! Файл буде завантажено автоматично.');
}

function exportFinancialReport() {
    alert('Фінансовий звіт експортовано в Excel!');
}

function generateFinancialReport() {
    alert('PDF звіт згенеровано!');
}

function exportPlayersCSV() {
    alert('Дані гравців експортовано в CSV!');
}

function exportContractsJSON() {
    alert('Дані контрактів експортовано в JSON!');
}

function exportAnalyticsExcel() {
    alert('Аналітичні дані експортовано в Excel!');
}

function generateFullReport() {
    alert('Повний звіт згенеровано в PDF!');
}

// Vehicle Management Functions
function searchVehicles() {
    const searchTerm = document.getElementById('vehicleSearch')?.value.toLowerCase() || '';
    const table = document.getElementById('vehiclesTable');
    if (!table) return;
    const rows = table.getElementsByTagName('tr');
    
    for (let i = 0; i < rows.length; i++) {
        const cells = rows[i].getElementsByTagName('td');
        let found = false;
        
        for (let j = 0; j < cells.length; j++) {
            if (cells[j].textContent.toLowerCase().includes(searchTerm)) {
                found = true;
                break;
            }
        }
        
        rows[i].style.display = found ? '' : 'none';
    }
}

function openAddVehicleModal() {
    const modal = document.getElementById('addVehicleModal');
    if (modal) modal.style.display = 'block';
}

function closeAddVehicleModal() {
    const modal = document.getElementById('addVehicleModal');
    if (modal) modal.style.display = 'none';
    const form = document.getElementById('addVehicleForm');
    if (form) form.reset();
}

function viewVehicle(vehicleId) {
    currentVehicleId = vehicleId;
    const modal = document.getElementById('viewVehicleModal');
    const details = document.getElementById('vehicleDetails');
    if (!modal || !details) return;
    
    const vehicleData = {
        1: {
            number: 'АК-1234',
            type: 'Автобус',
            brand: 'Mercedes Citaro',
            year: 2020,
            capacity: 85,
            fuel: 28.5,
            condition: 'Відмінний',
            status: 'Активний'
        }
    };
    
    const vehicle = vehicleData[vehicleId] || vehicleData[1];
    
    details.innerHTML = `
        <div style="display: grid; grid-template-columns: 1fr 1fr; gap: 2rem;">
            <div>
                <h4>Основна інформація</h4>
                <p><strong>Номер:</strong> ${vehicle.number}</p>
                <p><strong>Тип:</strong> ${vehicle.type}</p>
                <p><strong>Марка/Модель:</strong> ${vehicle.brand}</p>
                <p><strong>Рік випуску:</strong> ${vehicle.year}</p>
                <p><strong>Статус:</strong> <span class="status-badge status-active">${vehicle.status}</span></p>
            </div>
            <div>
                <h4>Технічні характеристики</h4>
                <p><strong>Пасажиромісткість:</strong> ${vehicle.capacity}</p>
                <p><strong>Витрата палива:</strong> ${vehicle.fuel} л/100км</p>
                <p><strong>Технічний стан:</strong> ${vehicle.condition}</p>
            </div>
        </div>
        <div style="margin-top: 2rem; display: flex; gap: 1rem; justify-content: flex-end;">
            <button class="btn btn-warning" onclick="editVehicle(${vehicleId})">Редагувати</button>
            <button class="btn" onclick="closeViewVehicleModal()" style="background: #6c757d; color: white;">Закрити</button>
        </div>
    `;
    
    modal.style.display = 'block';
}

function closeViewVehicleModal() {
    const modal = document.getElementById('viewVehicleModal');
    if (modal) modal.style.display = 'none';
}

function editVehicle(vehicleId) {
    alert(`Редагування транспорту з ID: ${vehicleId}`);
    closeViewVehicleModal();
}

function deleteVehicle(vehicleId) {
    if (confirm('Ви впевнені, що хочете видалити цей транспорт?')) {
        alert(`Транспорт з ID: ${vehicleId} видалений`);
    }
}

// Route Management Functions
function searchRoutes() {
    const searchTerm = document.getElementById('routeSearch')?.value.toLowerCase() || '';
    const table = document.getElementById('routesTable');
    if (!table) return;
    const rows = table.getElementsByTagName('tr');
    
    for (let i = 0; i < rows.length; i++) {
        const cells = rows[i].getElementsByTagName('td');
        let found = false;
        
        for (let j = 0; j < cells.length; j++) {
            if (cells[j].textContent.toLowerCase().includes(searchTerm)) {
                found = true;
                break;
            }
        }
        
        rows[i].style.display = found ? '' : 'none';
    }
}

function openAddRouteModal() {
    const modal = document.getElementById('addRouteModal');
    if (modal) modal.style.display = 'block';
}

function closeAddRouteModal() {
    const modal = document.getElementById('addRouteModal');
    if (modal) modal.style.display = 'none';
    const form = document.getElementById('addRouteForm');
    if (form) form.reset();
}

function viewRoute(routeId) {
    currentRouteId = routeId;
    alert(`Перегляд маршруту з ID: ${routeId}`);
}

function editRoute(routeId) {
    alert(`Редагування маршруту з ID: ${routeId}`);
}

function optimizeRoute(routeId) {
    if (confirm('Ви хочете оптимізувати цей маршрут?')) {
        alert(`Маршрут з ID: ${routeId} оптимізовано`);
    }
}

function closeViewRouteModal() {
    const modal = document.getElementById('viewRouteModal');
    if (modal) modal.style.display = 'none';
}

// Driver Management Functions
function searchDrivers() {
    const searchTerm = document.getElementById('driverSearch')?.value.toLowerCase() || '';
    const table = document.getElementById('driversTable');
    if (!table) return;
    const rows = table.getElementsByTagName('tr');
    
    for (let i = 0; i < rows.length; i++) {
        const cells = rows[i].getElementsByTagName('td');
        let found = false;
        
        for (let j = 0; j < cells.length; j++) {
            if (cells[j].textContent.toLowerCase().includes(searchTerm)) {
                found = true;
                break;
            }
        }
        
        rows[i].style.display = found ? '' : 'none';
    }
}

function openAddDriverModal() {
    const modal = document.getElementById('addDriverModal');
    if (modal) modal.style.display = 'block';
}

function closeAddDriverModal() {
    const modal = document.getElementById('addDriverModal');
    if (modal) modal.style.display = 'none';
    const form = document.getElementById('addDriverForm');
    if (form) form.reset();
}

function viewDriver(driverId) {
    currentDriverId = driverId;
    alert(`Перегляд водія з ID: ${driverId}`);
}

function editDriver(driverId) {
    alert(`Редагування водія з ID: ${driverId}`);
}

function assignDriver(driverId) {
    alert(`Призначення водія з ID: ${driverId}`);
}

function editDriverAssignment(assignmentId) {
    alert(`Редагування призначення з ID: ${assignmentId}`);
}

function removeDriverAssignment(assignmentId) {
    if (confirm('Ви хочете змінити призначення?')) {
        alert(`Призначення з ID: ${assignmentId} змінено`);
    }
}

function closeViewDriverModal() {
    const modal = document.getElementById('viewDriverModal');
    if (modal) modal.style.display = 'none';
}

// Export Functions
function exportVehiclesCSV() {
    alert('Дані транспорту експортовано в CSV!');
}

function exportRoutesJSON() {
    alert('Дані маршрутів експортовано в JSON!');
}

// Form Submissions
document.addEventListener('DOMContentLoaded', function() {
    // Add Player Form
    const addPlayerForm = document.getElementById('addPlayerForm');
    if (addPlayerForm) {
        addPlayerForm.addEventListener('submit', function(e) {
            e.preventDefault();
            alert('Новий гравець додано успішно!');
            closeAddPlayerModal();
        });
    }
    
    // Add Contract Form
    const addContractForm = document.getElementById('addContractForm');
    if (addContractForm) {
        addContractForm.addEventListener('submit', function(e) {
            e.preventDefault();
            alert('Новий контракт створено успішно!');
            closeAddContractModal();
        });
    }
    
    // Add Vehicle Form
    const addVehicleForm = document.getElementById('addVehicleForm');
    if (addVehicleForm) {
        addVehicleForm.addEventListener('submit', function(e) {
            e.preventDefault();
            alert('Новий транспорт додано успішно!');
            closeAddVehicleModal();
        });
    }
    
    // Add Route Form
    const addRouteForm = document.getElementById('addRouteForm');
    if (addRouteForm) {
        addRouteForm.addEventListener('submit', function(e) {
            e.preventDefault();
            alert('Новий маршрут створено успішно!');
            closeAddRouteModal();
        });
    }
    
    // Add Driver Form
    const addDriverForm = document.getElementById('addDriverForm');
    if (addDriverForm) {
        addDriverForm.addEventListener('submit', function(e) {
            e.preventDefault();
            alert('Новий водій додано успішно!');
            closeAddDriverModal();
        });
    }
});

// Close modals when clicking outside
window.onclick = function(event) {
    const modals = document.getElementsByClassName('modal');
    for (let i = 0; i < modals.length; i++) {
        if (event.target === modals[i]) {
            modals[i].style.display = 'none';
        }
    }
}

// Logout functionality
document.addEventListener('DOMContentLoaded', function() {
    const logoutBtn = document.querySelector('.logout-btn');
    if (logoutBtn) {
        logoutBtn.addEventListener('click', function() {
            if (confirm('Ви впевнені, що хочете вийти з системи?')) {
                alert('Ви успішно вийшли з системи!');
                // Here would be actual logout logic
            }
        });
    }
});
