import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component'; // Ajouter cette ligne
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { ProfileComponent } from './electeur/profile/profile.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent }, // Ajouter cette ligne
  { path: 'admin/dashboard', component: DashboardComponent },
  { path: 'electeur/profile', component: ProfileComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
];
