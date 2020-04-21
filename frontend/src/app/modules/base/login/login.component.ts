import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../../auth/authentication.service';
import {LoadingService} from '../../../api/loading.service';
import {MessageService} from "../../../api/commons/message.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder, private router: Router, private authService: AuthenticationService,
    private loadingService: LoadingService, private messageService: MessageService) {
    if (this.authService.isLoggedIn()) {
      this.router.navigate(['/']);
    }
  }

  ngOnInit() {
    if(this.authService.isLoggedIn()) {
      this.router.navigateByUrl('/pet-owner/book-visit')
    }

    this.loginForm = this.formBuilder.group({
      email: ['test@gmail.com', [Validators.required, Validators.email]],
      password: ['test', Validators.required]
    });
  }

  get fields() {
    return this.loginForm.controls;
  }

  onSubmit() {
    this.loadingService.loadingSubject.next(true);
    this.authService.login(this.fields.email.value, this.fields.password.value)
    .subscribe(
      authResponse => {
        localStorage.setItem('token', authResponse.token);
        this.router.navigate(['/pet-owner/book-visit']);
        this.loadingService.loadingSubject.next(false);
      },
      error => {
        this.loadingService.loadingSubject.next(false);
        this.messageService.error(error.error.details);
      });
  }
}
