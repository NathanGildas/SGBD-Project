// auth.js
document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Simuler une vérification d'authentification
    if (username === 'admin' && password === 'password') {
        alert('Connexion réussie !');
        window.location.href = 'admin-dashboard.html';
    } else {
        alert('Nom d\'utilisateur ou mot de passe incorrect.');
    }
});