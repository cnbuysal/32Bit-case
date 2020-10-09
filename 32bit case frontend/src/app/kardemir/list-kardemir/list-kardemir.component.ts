import { AuthService } from './../../auth/shared/auth.service';
import { Router } from '@angular/router';
import { CreateKardemirComponent } from './../create-kardemir/create-kardemir.component';
import { KardemirModel } from './../../shared/kardemir-model';
import { KardemirService } from 'src/app/shared/kardemir.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { throwError } from 'rxjs';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';

@Component({
  selector: 'app-list-kardemir',
  templateUrl: './list-kardemir.component.html',
  styleUrls: ['./list-kardemir.component.css'],
})
export class ListKardemirComponent implements OnInit {
  isLoggedOut: boolean;
  kardemirs: Array<KardemirModel>;
  listData: MatTableDataSource<any>;
  displayedColumns: string[] = [
    'active',
    'kardemir1',
    'kardemir2',
    'kardemir3',
    'customerId',
    'dop',
    'heatNo',
    'labelNo',
    'length',
    'product',
    'quality',
    'quantity',
    'weight',
    'createdUser',
    'updatedUser',
    'actions',
  ];

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  searchKey: string;
  constructor(
    private kardemirService: KardemirService,
    private authService : AuthService,
    private dialog: MatDialog,
    private router:Router
  ) {
    this.isLoggedOut = !this.authService.isLoggedIn();
  }

  ngOnInit(): void {
    this.kardemirService.getAllKardemirs().subscribe(
      (data) => {
        this.kardemirs = data;
        this.listData = new MatTableDataSource(this.kardemirs);
        this.listData.sort = this.sort;
        this.listData.paginator = this.paginator;
      },
      (error) => {
        throwError(error);
      }
    );
  }
  onSearchClear() {
    this.searchKey = '';
    this.applyFilter();
  }

  applyFilter() {
    this.listData.filter = this.searchKey.trim().toLowerCase();
  }

  onCreate() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = '60%';
    this.dialog.open(CreateKardemirComponent, dialogConfig);
  }

  onEdit(row) {
    this.kardemirService.populateForm(row);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = '60%';
    this.dialog.open(CreateKardemirComponent, dialogConfig);
  }

  onDelete(id){
    if(confirm("Are you sure to delete this record?")){
      this.kardemirService.deleteKardemir(id).subscribe((data) => {
        this.router.navigateByUrl('/');
      },
      (error) => {
        throwError(error);
      })
    }
    window.location.reload();
  }


  
}
