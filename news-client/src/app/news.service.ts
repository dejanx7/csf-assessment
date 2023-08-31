import { ElementRef, Injectable, inject } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { News } from './models';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class NewsService {

  constructor() { }

  private http = inject(HttpClient)

  postNews(news : FormData){

    

    console.log("news in service" , news)
    return this.http.post('/postnews', news)
  }

  uploadFile(file: ElementRef): Observable<any> {
    
    const formData =  new FormData()

    formData.set("file", file.nativeElement.files[0])

    return this.http.post('/upload', formData)
  }
}
