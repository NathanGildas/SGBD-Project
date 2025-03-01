// candidat.js
document.getElementById('register-candidate-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const candidateName = document.getElementById('candidate-name').value;
    const candidateParty = document.getElementById('candidate-party').value;
    const candidateBio = document.getElementById('candidate-bio').value;

    // Simuler l'enregistrement d'un candidat
    alert(`Candidat enregistré : ${candidateName} (${candidateParty})`);
    window.location.href = 'candidat-dashboard.html';
});

// Simuler le chargement des informations du candidat
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('candidate-name').textContent = 'Jean Dupont';
    document.getElementById('candidate-party').textContent = 'Parti Vert';
});