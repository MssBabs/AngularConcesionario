import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IVehiculo } from 'app/shared/model/vehiculo.model';


@Component({
  selector: 'jhi-vehiculo-detail-dialog',
  templateUrl: './vehiculo-detail-dialog.component.html'
})
export class VehiculoDetailsDialogComponent {
  @Input() vehiculo?: IVehiculo;

	constructor(private activeModal: NgbActiveModal) {}

  clear(){
    this.activeModal.dismiss();
  }

  close(){
    this.activeModal.close();
  }
}
