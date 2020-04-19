import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Resultado } from './resultado';

@Injectable({
    providedIn: 'root'
})
export class Servicio {

    private urlApi = `http://localhost:8080/api`;

    constructor(private http: HttpClient) { }

    getDefault(): Observable<Resultado> {
        return this.http.get<Resultado>(`${this.urlApi}`);
    }

    getSaludo(nombre: string): Observable<Resultado> {
        return this.http.get<Resultado>(`${this.urlApi}/${nombre}`);
    }

}
