import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { KardemirModel } from './kardemir-model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CreateKardemirModel } from '../kardemir/create-kardemir/create-kardemir-model';

@Injectable({
  providedIn: 'root',
})
export class KardemirService {


    createKardemirForm : FormGroup = new FormGroup({
      id:new FormControl(null),
      createdDate:new FormControl(null),
      createdUser:new FormControl(null),
      updatedDate:new FormControl(null),
      updatedUser:new FormControl(null),
      active: new FormControl('', [
        Validators.required,
        Validators.maxLength(1)
      ]),
      kardemir1: new FormControl('', Validators.required),
      kardemir2: new FormControl(''),
      kardemir3: new FormControl(''),
      customerId: new FormControl(''),
      dop: new FormControl(''),
      heatNo: new FormControl(''),
      labelNo: new FormControl(''),
      length: new FormControl(''),
      product: new FormControl(''),
      quality: new FormControl(''),
      quantity: new FormControl(''),
      weight: new FormControl(''),
      buMessageTimePB: new FormControl(''),
    });
  constructor(private http: HttpClient) {
  }
  

  getAllKardemirs(): Observable<Array<KardemirModel>> {
    return this.http.get<Array<KardemirModel>>(
      'http://localhost:8080/api/kardemirs'
    );
  }

  createKardemir(kardemir: CreateKardemirModel): Observable<any> {
    return this.http.post('http://localhost:8080/api/kardemirs/', kardemir);
  }

  updateKardemir(id: number, kardemir: CreateKardemirModel): Observable<any> {
    return this.http.put(
      'http://localhost:8080/api/kardemirs/' + id ,
      kardemir
    );
  }

  deleteKardemir(id: number): Observable<any> {
    return this.http.delete('http://localhost:8080/api/kardemirs/' + id );
  }

  populateForm(kardemir){
    this.createKardemirForm.setValue(kardemir);
  }
}
