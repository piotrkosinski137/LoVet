import {Injectable} from '@angular/core';
import {MatSnackBar, MatSnackBarConfig} from "@angular/material/snack-bar";
import {TranslateService} from "@ngx-translate/core";

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private snackBar: MatSnackBar, private translate: TranslateService) {
  }

  error(messageCode: string) {
    this.snackBar.open(this.translateMessage('Error.' + messageCode), undefined, snackBarConfig('snackbar-warn'));
  }

  success(messageCode: string) {
    this.snackBar.open(this.translateMessage('Success.' + messageCode), undefined, snackBarConfig('snackbar-success'));
  }

  private translateMessage(messageCode: string) {
    return this.translate.instant(messageCode)
  }
}


declare type SnackBarType = 'snackbar-info' | 'snackbar-warn' | 'snackbar-success';
export const snackBarConfig = (type: SnackBarType): MatSnackBarConfig => {
  return {
    duration: 3000,
    horizontalPosition: 'right',
    verticalPosition: 'bottom',
    panelClass: type
  };
};
