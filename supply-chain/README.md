# Cartographer [follow along](https://tanzucommunityedition.io/posts/build-modern-software-supply-chains-with-cartographer/)

```bash
tanzu package available list -o yaml | yq  '.[].display-name'
tanzu package installed list
```

## Deploy workload

```bash
yq developer/workload.yaml

kubectl apply workload -f developer/workload.yaml
kubectl get workload tanzu-java-web-app -o yaml | yq 
kubectl get all,httpproxies
```

## Study Cartographer

```bash
kubectl api-resources --api-group carto.run
kubectl get clustersourcetemplate,clusterimagegemplate,clustertemplate
```

## Source - Flux

```bash
kubectl get clustersourcetemplate source -o yaml | yq 'del(.metadata)'
kubectl get gitrepository tanzu-java-web-app -o yaml | yq 'del(.metadata)'
```

## Build - kpack

```bash
kubectl get clusterimagetemplate image -o yaml | yq 'del(.metadata)'
kubectl get cnbimage tanzu-java-web-app -o yaml | yq 'del(.metadata)'
```

## Customizations

Install knative serving

```bash
tanzu package available list knative-serving.community.tanzu.vmware.com
tanzu package install knative-serving \
--package-name knative-serving.community.tanzu.vmware.com \
--version 1.0.0 -f knative-values.yaml
```

Create a new supply chain

```bash
kubectl apply -f app-operator/app-deploy-template-kn.yaml app-operator/supply-chain-n.yaml

kubectl apply -f developer/workload-kn.yaml
kubectl tree workload tanzu-java-web-app-kn
kubectl get all --selector serving.knative.dev/service=tanzu-java-web-app
```