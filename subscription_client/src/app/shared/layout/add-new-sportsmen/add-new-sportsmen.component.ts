import { Component, ElementRef, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { GetSportsmenByIDResp } from '../../interfase/interface';
import { ServiceService } from '../../service.service';

@Component({
  selector: 'app-add-new-sportsmen',
  templateUrl: './add-new-sportsmen.component.html',
  styleUrls: ['./add-new-sportsmen.component.css']
})
export class AddNewSportsmenComponent {
  formAdd: FormGroup | any
  group = "LITTLE_GROUP"
  number= null;

  constructor(private fb: FormBuilder, private service: ServiceService, private route: ActivatedRoute, private router:Router){this._createFormUpdate() }
 
  ngOnInit(): void {
    
    
  }


  _createFormUpdate(){
    this.formAdd = this.fb.group(
      {
        nameAdd: [''],
        lastNameAdd: [''],
        numberOfWorkoutAdd: ['']
      }
    )
  }

  @ViewChild('mySelect') mySelect!: ElementRef;



  submit(){
    const sportsmenReq = {
      name: this.formAdd.value.nameAdd,
      lastName: this.formAdd.value.lastNameAdd,
      numberWorkouts: this.formAdd.value.numberOfWorkoutAdd,
      group: this.mySelect.nativeElement.value
    }
    this.service.addSportsmen(sportsmenReq).subscribe(()=>{
      this.router.navigate(['/08d3n7i26a377m81'])
    })
  }
}
