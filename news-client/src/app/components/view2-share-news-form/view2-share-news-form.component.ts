import { Component, ElementRef, OnInit, ViewChild, inject} from '@angular/core';
import {FormBuilder, FormGroup, FormArray, Validators} from '@angular/forms'
import { Subscription, findIndex } from 'rxjs';
import { News } from 'src/app/models';
import { NewsService } from 'src/app/news.service';


@Component({
  selector: 'app-view2-share-news-form',
  templateUrl: './view2-share-news-form.component.html',
  styleUrls: ['./view2-share-news-form.component.css']
})
export class View2ShareNewsFormComponent implements OnInit{


  shareNewsForm! : FormGroup
  tagList: string[] = []

  private fb = inject(FormBuilder)
  private service = inject(NewsService)

  @ViewChild('toUpload')
  toUpload! : ElementRef
  sub$!: Subscription
  msg : string = ''

  ngOnInit(): void {

    this.shareNewsForm = this.fb.group({
      title: this.fb.control<string>('', [Validators.required, Validators.min(5)]),
      photo: this.fb.control<string>('', [Validators.required]),
      description: this.fb.control<string>('' , [Validators.required, Validators.min(5)]),
      tags: this.fb.control<string>('' , [])
    })
  }

  addTag(){

    let tagText = this.shareNewsForm.get('tags')?.value
    console.log("tags are " , tagText)

    this.tagList = tagText.split(" ")
    console.log(this.tagList)

  }

  removeTag(){
    // remove tag item cbl 
    this.tagList.splice(0, 1)
  }

  submitForm(){
    

    let news = this.shareNewsForm.value
    console.log("form values are: " , news)

    const formData = new FormData()
    formData.set('title', this.shareNewsForm.get('title')?.value)
    formData.set('photo', this.shareNewsForm.get('photo')?.value)
    formData.set('description', this.shareNewsForm.get('description')?.value)
    formData.set('tags', this.shareNewsForm.get('tags')?.value)


    this.sub$ = this.service.postNews(formData).subscribe(
      (result) => {console.log(result)}

    )

    this.service.uploadFile(this.toUpload).subscribe(
      (result) => {console.log(result)}
    )

    this.msg = 'successfully added'

    
  }
}




