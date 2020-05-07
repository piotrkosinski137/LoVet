import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../../auth/authentication.service";
import {LoadingService} from "../../../api/loading.service";
import {RegisterRequest} from "./register.request";
import {MessageService} from "../../../api/commons/message.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder, private router: Router, private authService: AuthenticationService,
    public loadingService: LoadingService, private messageService: MessageService) {
  }

  ngOnInit() {
    if (this.authService.isLoggedIn()) {
      this.router.navigateByUrl('/pet-owner/book-visit')
    }

    this.registerForm = this.formBuilder.group({
      email: ['he@o2.pl', [Validators.required, Validators.email]],
      password: ['Haslo123!', [Validators.required, Validators.minLength(7)]],
      repeatPassword: ['Haslo123!', [Validators.required, this.passwordMatcher.bind(this), Validators.minLength(7)]],
      name: ['Piotr', [Validators.required]],
      surname: ['Kosinski', [Validators.required]],
      phoneNumber: ['555444333', [Validators.required, Validators.min(100000000), Validators.max(999999999)]],
    });
  }

  get fields() {
    return this.registerForm.controls;
  }

  onSubmit() {
    this.loadingService.loadingSubject.next(true);
    this.authService.register(new RegisterRequest(
      this.fields.email.value,
      this.fields.password.value,
      this.fields.name.value,
      this.fields.surname.value,
      this.fields.phoneNumber.value,
    ))
    .subscribe(
      authResponse => {
        this.router.navigate(['/login']);
        this.loadingService.loadingSubject.next(false);
        this.messageService.success(authResponse.successCode);
      },
      error => {
        console.log(error)
        this.loadingService.loadingSubject.next(false);
        this.messageService.error(error.error.errorCode);
      });
  }

  private passwordMatcher(control: FormControl): { [s: string]: boolean } {
    if (this.registerForm && (control.value !== this.registerForm.controls.password.value)) {
      return {passwordNotMatch: true};
    }
    return null;
  }
}
