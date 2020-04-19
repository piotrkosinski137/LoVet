import {Pipe, PipeTransform} from "@angular/core";

@Pipe({name: 'getDatePart'})
export class GetDatePipe implements PipeTransform {
  transform(date: Date, part: string): string {
    if(date != null) {
      if(part === "MONTH") {
        const monthName = date.toLocaleString('en-EN', { month: 'long' });
        return monthName.charAt(0).toUpperCase() + monthName.substring(1);
      } else if(part == "HOUR") {
        let hour = date.getHours() + ':' + date.getMinutes();
        if(date.getMinutes() === 0) {
          hour = hour + '0';
        }
        return hour;
      }
    }
  }
}
