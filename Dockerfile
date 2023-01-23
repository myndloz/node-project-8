FROM node:13-alpine

RUN mkdir /opt/app
COPY app/*  /opt/app
EXPOSE 3000

WORKDIR /opt/app
RUN  npm install

CMD ["node", "server.js"]