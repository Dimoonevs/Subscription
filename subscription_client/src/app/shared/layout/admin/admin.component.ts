import { Component, ElementRef, ViewChild } from '@angular/core';
import { Groups, GroupsFreezedUnfreezedTrainingResp, UserRepo } from '../../interfase/interface';
import { ServiceService } from '../../service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {
  sportsmens: UserRepo | any;
  selectedOption: number = 1; 
  trainingIsFreezeAll: boolean | any; 
  trainingIsFreezeLittle: boolean | any; 
  trainingIsFreezeBeginner: boolean | any;
  trainingIsFreezeOlder: boolean | any;
  selelectedGroup: any = 1;
  grope!: number;
  groups!: Groups;

  constructor(private service: ServiceService, private router: Router){}

  ngOnInit(): void {
    this.service.getAllSportsmenOfGrope(0).subscribe((any:UserRepo) =>{
      this.sportsmens = any;
    })
    this.service.getTraining().subscribe((data: GroupsFreezedUnfreezedTrainingResp) => {
      this.trainingIsFreezeAll = data.data.trainingIsFreezeAll;
      this.trainingIsFreezeBeginner = data.data.trainingIsFreezeBeginner;
      this.trainingIsFreezeLittle = data.data.trainingIsFreezeLittle;
      this.trainingIsFreezeOlder = data.data.trainingIsFreezeOlder;
    })
  }
  @ViewChild('mySelect') mySelect!: ElementRef;

  handleSelection() {
    const selectedValue = this.mySelect.nativeElement.value;

    if (selectedValue === '1') {
      this.grope = 0;
      this.service.getAllSportsmenOfGrope(0).subscribe((any:UserRepo) =>{
        this.sportsmens = any;
        this.selelectedGroup = 1; 
      })
    } else if (selectedValue === '2') {
      this.grope = 1;
      this.service.getAllSportsmenOfGrope(1).subscribe((any:UserRepo) =>{
        this.sportsmens = any;
        this.selelectedGroup = 2; 
      })
    } else if (selectedValue === '3') {
      this.grope = 3;
      this.service.getAllSportsmenOfGrope(2).subscribe((any:UserRepo) =>{
        this.sportsmens = any;
        this.selelectedGroup = 3; 
      })
    }
  }

  openEdit(id: number){
    console.log("Success " + id)
    this.router.navigate(["/update", id])
  }

  routeToAddForm(){
    this.router.navigate(["/add"])
  }
  toogelTrainigAll(){
    const GropeReq = {
      grope: "ALL"
    }
    this.service.toggleTraning(GropeReq).subscribe(()=>{
      this.trainingIsFreezeAll = !this.trainingIsFreezeAll;
    })
  }
  toggleTrainig(){
    const selectedValue = this.mySelect.nativeElement.value;
    const GropeReq = {
      grope: ""
    }

    if (this.selelectedGroup === 1) {
      GropeReq.grope = "LITTLE_GROUP"
      this.trainingIsFreezeLittle = !this.trainingIsFreezeLittle;
    } else if (this.selelectedGroup === 2) {
      GropeReq.grope = "BEGINNERS_GROUP"
      this.trainingIsFreezeBeginner = !this.trainingIsFreezeBeginner;
    } else if (this.selelectedGroup === 3) {
      GropeReq.grope = "OLDER_GROUP"
      this.trainingIsFreezeOlder = !this.trainingIsFreezeOlder
    }
    this.service.toggleTraning(GropeReq).subscribe(()=>{
      console.log(this.selelectedGroup)
    })
  }

}
