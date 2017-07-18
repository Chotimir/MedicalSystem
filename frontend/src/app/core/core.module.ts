import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {AdmissionService} from "./services/form/admission.service";
import {ComorbiditiesService} from "./services/form/comorbidities.service";
import {ComplicationsService} from "./services/form/complications.service";
import {ExaminationsService} from "./services/form/examinations.service";
import {FollowUpVisitService} from "./services/form/follow-up-visit.service";
import {PersonalDataService} from "./services/form/personal-data.service";
import {OperationService} from "./services/form/operation.service";
import {TroponinsService} from "./services/form/troponins.service";
import {AuthGuard} from "./auth-guard/auth.guard";
import {AdminAuthGuard} from "./auth-guard/admin-auth.guard";
import {AuthService} from "./services/auth.service";
import {ExportService} from "./services/export.service";
import {UsersService} from "./services/users.service";
import {PatientsService} from "./services/patients.service";

@NgModule({
  imports: [
    CommonModule
  ],
  providers: [
    AuthGuard,
    AdminAuthGuard,
    AdmissionService,
    AuthService,
    ExportService,
    UsersService,
    PatientsService,
    ComorbiditiesService,
    ComplicationsService,
    ExaminationsService,
    FollowUpVisitService,
    OperationService,
    PersonalDataService,
    TroponinsService
  ]
})
export class CoreModule { }
