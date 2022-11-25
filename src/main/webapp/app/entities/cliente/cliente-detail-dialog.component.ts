import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICliente } from 'app/shared/model/cliente.model';


/*@Component({
  selector: 'jhi-cliente-detail-dialog',
  templateUrl: './cliente-detail-dialog.component.html'
})
export class ClienteDetailsDialogComponent {
  @Input() cliente?: ICliente;

	constructor(private activeModal: NgbActiveModal) {}

  clear(){
    this.activeModal.dismiss();
  }

  close(){
    this.activeModal.close();
  }
}*/
