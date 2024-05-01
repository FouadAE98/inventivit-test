import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FormserviceService } from '../services/formservice.service';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  myForm: FormGroup = new FormBuilder().group({
    fullName: ['', Validators.required],
    intention: ['', Validators.required],
  });
  constructor(private formserviceService : FormserviceService) {}

  submite() {
    this.formserviceService.submite(this.myForm.value.fullName, this.myForm.value.intention);
  }

}
