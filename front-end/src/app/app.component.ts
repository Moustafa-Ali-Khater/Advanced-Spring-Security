import { Component } from '@angular/core';
import { PlayerService } from './service/player.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'advancedspringsecurity';

  constructor(private playerService :PlayerService) {
    /*this.ngOnInit()
    this.ngOnInit1()*/
  }

  ngOnInit(): void {
    this.playerService.getPlayer().subscribe(
      data => {
        let xsrf = this.getCookie('XSRF-TOKEN');
        console.log(xsrf)
        console.log(`------------------- ${data}`)
        console.log(document.cookie)
      }
    );
  }

  ngOnInit1(): void {
    this.playerService.getPlayerBas().subscribe(
      data => {
        let xsrf = this.getCookie('XSRF-TOKEN');
        console.log(xsrf)
        console.log('-------------------')
        console.log(data)
      }
    );
  }

  getCookie(name: string) {
    let cookie = {};
    console.log(document.cookie.valueOf() + "  77777")
    document.cookie.split(';').forEach(function(el) {
      console.log(el)
      let [k,v] = el.split('=');
      // @ts-ignore
      cookie[k.trim()] = v;
      console.log()
    })
    // @ts-ignore

    // @ts-ignore
    return cookie[name];
  }

}
