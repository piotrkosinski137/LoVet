import {Component, Input, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {
  DayWorkingHoursModalComponent,
  WorkingDayType
} from "./day-working-hours-modal/day-working-hours-modal.component";
import {VisitService} from "../../../../../../api/visit.service";

@Component({
  selector: 'app-calendar-day',
  templateUrl: './calendar-day.component.html',
  styleUrls: ['./calendar-day.component.scss']
})
export class CalendarDayComponent implements OnInit {

  @Input()
  date: Date;
  WorkingDayType = WorkingDayType;
  workingDayType: WorkingDayType = WorkingDayType.NONE;

  constructor(private dialog: MatDialog, private visitService: VisitService) {
  }

  ngOnInit() {
  }

  onDayClicked() {
    const dialogRef = this.dialog.open(DayWorkingHoursModalComponent, {
      data: {
        date: this.date,
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      if(result.workingDayType === undefined) {
        this.workingDayType = WorkingDayType.NONE;
      } else {
        this.workingDayType = result.workingDayType;
      }
      this.visitService.saveBlank(result.selectedHours).subscribe();
    });
  }
}
