"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var app_hero_1 = require("./app_hero");
var AppComponent = (function () {
    function AppComponent() {
        this.title = 'Tour of Heroes';
        //heroes = ['Windstorm', 'Bombasto', 'Magneta', 'Tornado'];
        this.heroes = [
            new app_hero_1.Hero(1, 'Windstorm'),
            new app_hero_1.Hero(2, 'Bombasto'),
            new app_hero_1.Hero(3, 'Magneta'),
            new app_hero_1.Hero(4, 'Tornado')
        ];
        this.myHero = this.heroes[1];
    }
    AppComponent = __decorate([
        core_1.Component({
            selector: 'my-app',
            template: "\n    <h1>{{title}}</h1>\n    <h2>{{myHero.name}}</h2>\n    <div><label>id: </label>{{myHero.id}}</div>\n    <div>\n        <label>name: </label>\n        <input [(ngModel)]=\"myHero.name\" placeholder=\"name\">\n    </div>\n    <!--<p>Heroes:</p>\n    <ul>\n        <li *ngFor=\"let hero of heroes\">\n            {{hero.name}}\n        </li>\n    </ul>\n    <p *ngIf=\"heroes.length > 3\">There are two many heroes !</p>-->\n    "
        }), 
        __metadata('design:paramtypes', [])
    ], AppComponent);
    return AppComponent;
}());
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map