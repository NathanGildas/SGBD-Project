import { AuthService } from '../auth.service';
import {Router, RouterLink} from '@angular/router';
import {FormsModule} from '@angular/forms';
import { Component } from '@angular/core';
import { fadeInAnimation, slideInAnimation } from '../../shared/animations';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  animations: [fadeInAnimation, slideInAnimation],
  styleUrls: ['./login.component.css'],
  imports: [
    FormsModule,
    RouterLink
  ]
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    this.authService.login({ username: this.username, password: this.password }).subscribe(
      (response) => {
        console.log('Connexion réussie', response);
        this.router.navigate(['/admin/dashboard']);
      },
      (error) => {
        console.error('Erreur de connexion', error);
      }
    );
  }
}
