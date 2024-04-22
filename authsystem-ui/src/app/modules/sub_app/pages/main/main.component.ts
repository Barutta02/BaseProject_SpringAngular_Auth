import { Component, OnInit, inject } from '@angular/core';
import { TokenService } from 'src/app/services/token/token.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})

export class MainComponent implements OnInit {
  tokenService = inject(TokenService);
  username: string = '';

  ngOnInit(): void {
    console.log(this.tokenService.getuserFullName());
    this.username = this.tokenService.getuserFullName();
  }
}
