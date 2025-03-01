// parrainage.js
document.addEventListener('DOMContentLoaded', function() {
    const candidates = [
        { name: 'Jean Dupont', party: 'Parti Vert' },
        { name: 'Marie Curie', party: 'Parti Bleu' },
        { name: 'Pierre Durand', party: 'Parti Rouge' }
    ];

    const candidateList = document.getElementById('candidate-list');
    const candidateSelect = document.getElementById('candidate-select');

    candidates.forEach(candidate => {
        const listItem = document.createElement('li');
        listItem.textContent = `${candidate.name} (${candidate.party})`;
        candidateList.appendChild(listItem);

        const option = document.createElement('option');
        option.value = candidate.name;
        option.textContent = `${candidate.name} (${candidate.party})`;
        candidateSelect.appendChild(option);
    });
});

document.getElementById('sponsor-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const selectedCandidate = document.getElementById('candidate-select').value;
    alert(`Vous avez parrainé : ${selectedCandidate}`);
});