import { NbMenuItem } from '@nebular/theme';

export const MENU_ITEMS: NbMenuItem[] = [
  {
    title: 'Dashboard',
    icon: 'home-outline',
    link: '/pages/dashboard',
    home: true,
  },
  {
    title: 'Pacientes',
    icon: 'people-outline',
    link: '/pages/paciente'
  },
  {
    title: 'Disponiblidade de Horários',
    icon: 'clock-outline',
    link: '/pages/consultas'
  },
  {
    title: 'Agenda',
    icon: 'book-outline',
    link: '/pages/consultation'
  },
  {
    title: 'Perfil',
    icon: 'person-outline',
    link: '/pages/profile-doctor'
  },  
];
