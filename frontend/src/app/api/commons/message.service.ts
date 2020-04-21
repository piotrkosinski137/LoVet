import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private popupService: ToastrService) { }

  error(message: string) {
    this.popupService.error(message)
  }

  success(message: string) {
    this.popupService.success(message)
  }

  info(message: string) {
    this.popupService.info(message)
  }
}
