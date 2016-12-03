import { Component } from '@angular/core';
import {Hero} from "./app_hero";

@Component({
  selector: 'my-app',
  template: `
    <h1>{{title}}</h1>
    <h2>{{myHero.name}}</h2>
    <div><label>id: </label>{{myHero.id}}</div>
    <div>
        <label>name: </label>
        <input value="{{myHero.name}}" placeholder="name">
    </div>
    <!--<p>Heroes:</p>
    <ul>
        <li *ngFor="let hero of heroes">
            {{hero.name}}
        </li>
    </ul>
    <p *ngIf="heroes.length > 3">There are two many heroes !</p>-->
    `
})
export class AppComponent  {
  title = 'Tour of Heroes';
  //heroes = ['Windstorm', 'Bombasto', 'Magneta', 'Tornado'];
  heroes = [
    new Hero(1, 'Windstorm'),
    new Hero(2, 'Bombasto'),
    new Hero(3, 'Magneta'),
    new Hero(4, 'Tornado')
  ]
  myHero = this.heroes[1];
}
