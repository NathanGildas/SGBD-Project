import { Component } from '@angular/core';
import { fadeInAnimation, slideInAnimation } from '../../shared/animations';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
  animations: [fadeInAnimation, slideInAnimation],
  imports: [
    RouterLink
  ]
})
export class DashboardComponent {
  message = 'Tableau de bord Admin';
  logout() {
    console.log('Déconnexion');
  }
}
