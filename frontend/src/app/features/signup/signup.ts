import { User } from '../../services/auth/user';
import { AuthService } from '../../services/auth/auth';
import { Component, OnInit } from '@angular/core';
import { NgForm, FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  templateUrl: './signup.html',
  standalone: true,
  imports: [FormsModule, CommonModule]
})
export class Signup implements OnInit {
  user: User = { username: '', password: '' };

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  signup(credentials: User) {
    this.authService.signup(credentials).subscribe(res => {
      console.log('res ', res);
      // Redirect to user dashboard
    });
  }
}