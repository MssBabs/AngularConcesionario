import { Component, OnInit } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { ITrabajador, Trabajador } from 'app/shared/model/trabajador.model';
import { TrabajadorService } from './trabajador.service';

@Component({
  selector: 'jhi-trabajador-commission',
  templateUrl: './trabajador-commission.component.html'
})
export class TrabajadorCommissionComponent implements OnInit {


  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

}
