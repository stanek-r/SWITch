import { Component, OnInit } from '@angular/core';

declare var videojs: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  public streamUrl?: string;

  ngOnInit(): void {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    if (urlParams.has('streamKey')) {
      this.streamUrl =
        'https://stream.swit-ch.live/source/' +
        urlParams.get('streamKey') +
        '/index.m3u8';
    }
    videojs('streamPlayer').play();
  }
}
