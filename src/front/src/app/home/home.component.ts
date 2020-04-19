import { Component, OnInit } from '@angular/core';
import { Servicio } from '../app.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  title = 'Consumir API';
  respuesta: string;
  error: string;

  constructor(private servicio: Servicio) {}

  consultar(nombre: string, $event: Event) {
    $event.preventDefault();

    this.error = undefined;
    this.respuesta = undefined;

    if (!nombre) {
      this.error = 'No escribió su nombre';
      return;
    }

    this.servicio.getSaludo(nombre).subscribe({
      next: resultado => this.respuesta = resultado.mensaje,
      error: err => {
        console.error(err);
        this.error = 'Error en la consulta';
      }
    });

  }
  
  ngOnInit() {
  }

}
