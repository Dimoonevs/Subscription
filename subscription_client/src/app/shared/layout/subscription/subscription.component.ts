import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ServiceService } from '../../service.service';
import { UserRepo } from '../../interfase/interface';

@Component({
  selector: 'app-subscription',
  templateUrl: './subscription.component.html',
  styleUrls: ['./subscription.component.css']
})
export class SubscriptionComponent implements OnInit {

  sportsmens: UserRepo | any;
  selectedOption: number = 1; 

  constructor(private service: ServiceService){}

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

  

}
