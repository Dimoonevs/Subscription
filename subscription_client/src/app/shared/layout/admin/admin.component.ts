import { Component, ElementRef, ViewChild } from '@angular/core';
import { UserRepo } from '../../interfase/interface';
import { ServiceService } from '../../service.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {
  sportsmens: UserRepo | any;
  selectedOption: number = 1; 

  constructor(private service: ServiceService, private router: Router){}

  ngOnInit(): void {
    this.service.getAllSportsmenOfGrope(0).subscribe((any:UserRepo) =>{
      this.sportsmens = any;
    })
  }
  @ViewChild('mySelect') mySelect!: ElementRef;

  handleSelection() {
    const selectedValue = this.mySelect.nativeElement.value;

    if (selectedValue === '1') {
      this.service.getAllSportsmenOfGrope(0).subscribe((any:UserRepo) =>{
        this.sportsmens = any;
      })
    } else if (selectedValue === '2') {
      this.service.getAllSportsmenOfGrope(1).subscribe((any:UserRepo) =>{
        this.sportsmens = any;
      })
    } else if (selectedValue === '3') {
      this.service.getAllSportsmenOfGrope(2).subscribe((any:UserRepo) =>{
        this.sportsmens = any;
      })
    }
  }

  openEdit(id: number){
    this.router.navigate(["/update", id])
  }

  routeToAddForm(){
    this.router.navigate(["/add"])
  }

}