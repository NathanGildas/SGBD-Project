// upload.js
document.getElementById('upload-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const fileInput = document.getElementById('voter-file');
    const file = fileInput.files[0];

    if (file) {
        alert(`Fichier ${file.name} téléversé avec succès.`);
        // Simuler le traitement du fichier
    } else {
        alert('Veuillez sélectionner un fichier.');
    }
});