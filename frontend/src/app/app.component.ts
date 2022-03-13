import { AfterViewInit, Component, ElementRef, ViewChild } from '@angular/core';

declare var videojs: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements AfterViewInit {
  public streamUrl?: string;

  @ViewChild('streamPlayer') streamPlayer!: ElementRef;

  constructor() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    if (urlParams.has('streamKey')) {
      this.streamUrl =
        'https://stream.swit-ch.live/source/' +
        urlParams.get('streamKey') +
        '/index.m3u8';
    }
  }

  ngAfterViewInit(): void {
    if (this.streamUrl && this.streamPlayer) {
      videojs(this.streamPlayer.nativeElement).play();
    }
  }
}
