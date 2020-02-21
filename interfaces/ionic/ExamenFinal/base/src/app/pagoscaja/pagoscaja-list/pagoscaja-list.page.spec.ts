import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { PagoscajaListPage } from './pagoscaja-list.page';

describe('PagoscajaListPage', () => {
  let component: PagoscajaListPage;
  let fixture: ComponentFixture<PagoscajaListPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PagoscajaListPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(PagoscajaListPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
