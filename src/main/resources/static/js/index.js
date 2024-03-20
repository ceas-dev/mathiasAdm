import { navigateTo } from './utils/router.js';
import { getToken } from './utils/token-handler.js';
const token = getToken();

if (token) {
  alert(JSON.stringify(token))
} else {
  navigateTo('sign-in')
}
