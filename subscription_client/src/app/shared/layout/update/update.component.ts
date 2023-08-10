import { Component, ElementRef, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { GetSportsmenByIDResp } from '../../interfase/interface';
import { ServiceService } from '../../service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent{
  formUpdate: FormGroup | any
  sportsmen!: GetSportsmenByIDResp | any;
  group!: string;
  id: any

  constructor(private fb: FormBuilder, private service: ServiceService, private route: ActivatedRoute, private router:Router){this._createFormUpdate() }
 
  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']
    this.service.getSpurtsmenByID(this.id).subscribe((data: GetSportsmenByIDResp)=>{
      this.sportsmen = data
      this.group = this.sportsmen.data.group
      console.log(this.group)
    })
    
  }


  _createFormUpdate(){
    this.formUpdate = this.fb.group(
      {
        nameUpdate: [''],
        lastNameUpdate: [''],
        numberOfWorkoutUpdate: ['']
      }
    )
  }

  @ViewChild('mySelect') mySelect!: ElementRef;


  get _nameUpdate(){return this.formUpdate.get("nameUpdate")}
  get _lastNameUpdate(){return this.formUpdate.get("lastNameUpdate")}
  get _numberOfWorkoutUpdate(){return this.formUpdate.get("numberOfWorkoutUpdate")}

  submit(){
    const sportsmenReq = { 
      name: this.formUpdate.value.nameUpdate,
      lastName: this.formUpdate.value.lastNameUpdate,
      numberWorkouts: this.formUpdate.value.numberOfWorkoutUpdate,
      group: this.mySelect.nativeElement.value
    }
    this.service.updateSportsmen(this.id, sportsmenReq).subscribe(()=>{
      this.router.navigate(['/08d3n7i26a377m81'])
    })
  }


}
