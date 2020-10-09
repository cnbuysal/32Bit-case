import { Router } from '@angular/router';
import { Component, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { KardemirService } from 'src/app/shared/kardemir.service';
import { throwError } from 'rxjs';
import { CreateKardemirModel } from './create-kardemir-model';
import { MatDialogRef, MatDialogConfig, MatDialog } from '@angular/material/dialog';
import { NullTemplateVisitor } from '@angular/compiler';

@Component({
  selector: 'app-create-kardemir',
  templateUrl: './create-kardemir.component.html',
  styleUrls: ['./create-kardemir.component.css'],
})
export class CreateKardemirComponent implements OnInit {
  createKardemirModel: CreateKardemirModel;

  constructor(
    public kardemirService: KardemirService,
    private router: Router,
    public dialogRef: MatDialogRef<CreateKardemirComponent>
  ) {
    this.createKardemirModel = {
      id :null,
      createdDate:null,
      createdUser:null,
      updatedDate:null,
      updatedUser:null,
      active: null,
      kardemir1: '',
      kardemir2: null,
      kardemir3: null,
      customerId: '',
      dop: '',
      heatNo: '',
      labelNo: '',
      length: '',
      product: '',
      quality: '',
      quantity: '',
      weight: '',
      buMessageTimePB: '',
    };
  }

  ngOnInit(): void {
    this.kardemirService.createKardemirForm;
  }

  onClear() {
    this.kardemirService.createKardemirForm.reset();
  }

  createKardemir() {
    this.createKardemirModel.active = this.kardemirService.createKardemirForm.get(
      'active'
    ).value;
    this.createKardemirModel.buMessageTimePB = this.kardemirService.createKardemirForm.get(
      'buMessageTimePB'
    ).value;
    this.createKardemirModel.customerId = this.kardemirService.createKardemirForm.get(
      'customerId'
    ).value;
    this.createKardemirModel.dop = this.kardemirService.createKardemirForm.get('dop').value;
    this.createKardemirModel.heatNo = this.kardemirService.createKardemirForm.get(
      'heatNo'
    ).value;
    this.createKardemirModel.kardemir1 = this.kardemirService.createKardemirForm.get(
      'kardemir1'
    ).value;
    this.createKardemirModel.kardemir2 = this.kardemirService.createKardemirForm.get(
      'kardemir2'
    ).value;
    this.createKardemirModel.kardemir3 = this.kardemirService.createKardemirForm.get(
      'kardemir3'
    ).value;
    this.createKardemirModel.labelNo = this.kardemirService.createKardemirForm.get(
      'labelNo'
    ).value;
    this.createKardemirModel.length = this.kardemirService.createKardemirForm.get(
      'length'
    ).value;
    this.createKardemirModel.product = this.kardemirService.createKardemirForm.get(
      'product'
    ).value;
    this.createKardemirModel.quality = this.kardemirService.createKardemirForm.get(
      'quality'
    ).value;
    this.createKardemirModel.quantity = this.kardemirService.createKardemirForm.get(
      'quantity'
    ).value;
    this.createKardemirModel.weight = this.kardemirService.createKardemirForm.get(
      'weight'
    ).value;


    if(this.kardemirService.createKardemirForm.valid){
      if(!this.kardemirService.createKardemirForm.get('id').value){
        this.kardemirService.createKardemir(this.createKardemirModel).subscribe(
          (data) => {
            this.router.navigateByUrl('/');
          },
          (error) => {
            throwError(error);
          }
        )
      }else{
        this.kardemirService.updateKardemir(this.kardemirService.createKardemirForm.get('id').value,this.createKardemirModel)
        .subscribe((data) => {
          this.router.navigateByUrl('/');
        },
        (error) => {
          throwError(error);
        })
      }
    }
    this.onClose();
  }

  onClose() {
    this.kardemirService.createKardemirForm.reset();
    this.dialogRef.close();
    window.location.reload();
  }

}
