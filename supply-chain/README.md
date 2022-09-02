```bash
tanzu package available list -o yaml | yq  '.[].display-name'
tanzu package installed list
