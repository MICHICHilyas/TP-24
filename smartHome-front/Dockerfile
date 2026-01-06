# Build Stage
FROM node:16-alpine AS build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# Run Stage
FROM nginx:alpine
COPY --from=build /app/dist/smart-home /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
