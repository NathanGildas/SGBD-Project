import { AuthService } from '../auth.service';
import {Router, RouterLink} from '@angular/router';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms'; // Importer FormsModule
import { fadeInAnimation, slideInAnimation } from '../../shared/animations';

@Component({
  selector: 'app-register',
  standalone: true, // Assurez-vous que le composant est autonome
  imports: [FormsModule, RouterLink], // Ajouter FormsModule ici
  templateUrl: './register.component.html',
  animations: [fadeInAnimation, slideInAnimation],
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  username: string = '';
  password: string = '';
  email: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    const user = {
      username: this.username,
      password: this.password,
      email: this.email,
    };

    this.authService.register(user).subscribe(
      (response) => {
        console.log('Inscription réussie', response);
        this.router.navigate(['/login']); // Redirection vers la page de connexion après inscription
      },
      (error) => {
        console.error('Erreur lors de l\'inscription', error);
      }
    );
  }
}
