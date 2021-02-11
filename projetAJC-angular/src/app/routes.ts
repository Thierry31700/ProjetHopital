import { Routes } from "@angular/router";
import { EmployeEditComponent } from "./crud/employe/employe-edit/employe-edit.component";
import { EmployeListComponent } from "./crud/employe/employe-list/employe-list.component";
import { HomeComponent } from "./home/home.component";
import { LoginComponent } from "./login/login.component";

export const routes: Routes = [
    { path: 'home', component: HomeComponent },
    { path: 'login', component: LoginComponent },
    { path: 'employe', component: EmployeListComponent },
    { path: 'employe/edit', component: EmployeEditComponent },
    { path: 'employe/edit/:id', component: EmployeEditComponent },
    
    { path: '', redirectTo: 'home', pathMatch: 'full' },
];