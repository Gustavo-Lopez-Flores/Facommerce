--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3 (Ubuntu 16.3-1.pgdg22.04+1)
-- Dumped by pg_dump version 16.3 (Ubuntu 16.3-1.pgdg22.04+1)

-- Started on 2024-06-23 19:35:37 -04

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 222 (class 1259 OID 49318)
-- Name: carrinhos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.carrinhos (
    id bigint NOT NULL,
    usuario_id bigint,
    data_criacao timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.carrinhos OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 49317)
-- Name: carrinhos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.carrinhos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.carrinhos_id_seq OWNER TO postgres;

--
-- TOC entry 3460 (class 0 OID 0)
-- Dependencies: 221
-- Name: carrinhos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.carrinhos_id_seq OWNED BY public.carrinhos.id;


--
-- TOC entry 218 (class 1259 OID 49297)
-- Name: categorias; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categorias (
    id bigint NOT NULL,
    nome character varying(255) NOT NULL
);


ALTER TABLE public.categorias OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 49296)
-- Name: categorias_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categorias_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.categorias_id_seq OWNER TO postgres;

--
-- TOC entry 3461 (class 0 OID 0)
-- Dependencies: 217
-- Name: categorias_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categorias_id_seq OWNED BY public.categorias.id;


--
-- TOC entry 224 (class 1259 OID 49331)
-- Name: itens_carrinho; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.itens_carrinho (
    id bigint NOT NULL,
    carrinho_id bigint,
    produto_id bigint,
    quantidade integer NOT NULL
);


ALTER TABLE public.itens_carrinho OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 49330)
-- Name: itens_carrinho_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.itens_carrinho_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.itens_carrinho_id_seq OWNER TO postgres;

--
-- TOC entry 3462 (class 0 OID 0)
-- Dependencies: 223
-- Name: itens_carrinho_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.itens_carrinho_id_seq OWNED BY public.itens_carrinho.id;


--
-- TOC entry 228 (class 1259 OID 49361)
-- Name: itens_pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.itens_pedido (
    id bigint NOT NULL,
    pedido_id bigint,
    produto_id bigint,
    quantidade integer NOT NULL,
    preco_unitario double precision NOT NULL
);


ALTER TABLE public.itens_pedido OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 49360)
-- Name: itens_pedido_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.itens_pedido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.itens_pedido_id_seq OWNER TO postgres;

--
-- TOC entry 3463 (class 0 OID 0)
-- Dependencies: 227
-- Name: itens_pedido_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.itens_pedido_id_seq OWNED BY public.itens_pedido.id;


--
-- TOC entry 230 (class 1259 OID 49378)
-- Name: pagamentos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pagamentos (
    id bigint NOT NULL,
    pedido_id bigint,
    valor double precision NOT NULL,
    data_pagamento timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    metodo_pagamento character varying(10) NOT NULL
);


ALTER TABLE public.pagamentos OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 49377)
-- Name: pagamentos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pagamentos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.pagamentos_id_seq OWNER TO postgres;

--
-- TOC entry 3464 (class 0 OID 0)
-- Dependencies: 229
-- Name: pagamentos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pagamentos_id_seq OWNED BY public.pagamentos.id;


--
-- TOC entry 226 (class 1259 OID 49348)
-- Name: pedidos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedidos (
    id bigint NOT NULL,
    usuario_id bigint,
    data_pedido timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    total double precision NOT NULL,
    status character varying(10) NOT NULL
);


ALTER TABLE public.pedidos OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 49347)
-- Name: pedidos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pedidos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.pedidos_id_seq OWNER TO postgres;

--
-- TOC entry 3465 (class 0 OID 0)
-- Dependencies: 225
-- Name: pedidos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pedidos_id_seq OWNED BY public.pedidos.id;


--
-- TOC entry 220 (class 1259 OID 49304)
-- Name: produtos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produtos (
    id bigint NOT NULL,
    nome character varying(255) NOT NULL,
    descricao text,
    preco double precision NOT NULL,
    quantidade_estoque integer NOT NULL,
    categoria_id bigint,
    imagem_url text
);


ALTER TABLE public.produtos OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 49303)
-- Name: produtos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produtos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.produtos_id_seq OWNER TO postgres;

--
-- TOC entry 3466 (class 0 OID 0)
-- Dependencies: 219
-- Name: produtos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.produtos_id_seq OWNED BY public.produtos.id;


--
-- TOC entry 216 (class 1259 OID 49284)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios (
    id bigint NOT NULL,
    cpf character varying(11) NOT NULL,
    nome character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    senha character varying(255) NOT NULL,
    data_nascimento date NOT NULL,
    telefone character varying(20) NOT NULL,
    tipo_usuario character varying(10) NOT NULL
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 49283)
-- Name: usuarios_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuarios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.usuarios_id_seq OWNER TO postgres;

--
-- TOC entry 3467 (class 0 OID 0)
-- Dependencies: 215
-- Name: usuarios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuarios_id_seq OWNED BY public.usuarios.id;


--
-- TOC entry 3260 (class 2604 OID 49391)
-- Name: carrinhos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carrinhos ALTER COLUMN id SET DEFAULT nextval('public.carrinhos_id_seq'::regclass);


--
-- TOC entry 3258 (class 2604 OID 49412)
-- Name: categorias id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categorias ALTER COLUMN id SET DEFAULT nextval('public.categorias_id_seq'::regclass);


--
-- TOC entry 3262 (class 2604 OID 49424)
-- Name: itens_carrinho id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itens_carrinho ALTER COLUMN id SET DEFAULT nextval('public.itens_carrinho_id_seq'::regclass);


--
-- TOC entry 3265 (class 2604 OID 49449)
-- Name: itens_pedido id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itens_pedido ALTER COLUMN id SET DEFAULT nextval('public.itens_pedido_id_seq'::regclass);


--
-- TOC entry 3266 (class 2604 OID 49478)
-- Name: pagamentos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamentos ALTER COLUMN id SET DEFAULT nextval('public.pagamentos_id_seq'::regclass);


--
-- TOC entry 3263 (class 2604 OID 49498)
-- Name: pedidos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedidos ALTER COLUMN id SET DEFAULT nextval('public.pedidos_id_seq'::regclass);


--
-- TOC entry 3259 (class 2604 OID 49528)
-- Name: produtos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produtos ALTER COLUMN id SET DEFAULT nextval('public.produtos_id_seq'::regclass);


--
-- TOC entry 3257 (class 2604 OID 49564)
-- Name: usuarios id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios ALTER COLUMN id SET DEFAULT nextval('public.usuarios_id_seq'::regclass);


--
-- TOC entry 3446 (class 0 OID 49318)
-- Dependencies: 222
-- Data for Name: carrinhos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.carrinhos (id, usuario_id, data_criacao) FROM stdin;
1	1	2024-06-23 18:57:41.954377
2	2	2024-06-23 18:57:41.954377
\.


--
-- TOC entry 3442 (class 0 OID 49297)
-- Dependencies: 218
-- Data for Name: categorias; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categorias (id, nome) FROM stdin;
1	Notebooks
\.


--
-- TOC entry 3448 (class 0 OID 49331)
-- Dependencies: 224
-- Data for Name: itens_carrinho; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.itens_carrinho (id, carrinho_id, produto_id, quantidade) FROM stdin;
1	1	1	2
2	1	2	1
3	2	3	3
\.


--
-- TOC entry 3452 (class 0 OID 49361)
-- Dependencies: 228
-- Data for Name: itens_pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.itens_pedido (id, pedido_id, produto_id, quantidade, preco_unitario) FROM stdin;
1	1	1	2	3899
2	2	3	1	5736.74
\.


--
-- TOC entry 3454 (class 0 OID 49378)
-- Dependencies: 230
-- Data for Name: pagamentos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pagamentos (id, pedido_id, valor, data_pagamento, metodo_pagamento) FROM stdin;
1	2	5736.74	2024-06-23 18:57:41.954377	cartao
\.


--
-- TOC entry 3450 (class 0 OID 49348)
-- Dependencies: 226
-- Data for Name: pedidos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedidos (id, usuario_id, data_pedido, total, status) FROM stdin;
1	1	2024-06-23 18:57:41.954377	7798	pendente
2	2	2024-06-23 18:57:41.954377	5736.74	pago
\.


--
-- TOC entry 3444 (class 0 OID 49304)
-- Dependencies: 220
-- Data for Name: produtos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.produtos (id, nome, descricao, preco, quantidade_estoque, categoria_id, imagem_url) FROM stdin;
1	Notebook Gamer Acer Nitro V15 ANV15-51-57WS i5 13ªGen 8GB RAM 512GB SSD RTX3050 15.6 FHD Linux Gutta	Descrição do Notebook Acer	3899	10	1	https://benchpromos.com.br/_next/image?url=https%3A%2F%2Fcdn.discordapp.com%2Fattachments%2F1200269957083189268%2F1250474358699200572%2Fimage-removebg-preview_11.png%3Fex%3D666b127f%26is%3D6669c0ff%26hm%3D5d4797574c9810d7cb672238c490872d1daad9c8552d883f840804a3cc91083c%26&w=1080&q=75
2	Notebook Predator Helios Neo PHN16-71-72W6 Ci7 13° Windows 11 Home 16GB 512GB SSD RTX 4060 16 WUXGA	Descrição do Notebook Predator	7899	5	1	https://benchpromos.com.br/_next/image?url=https%3A%2F%2Fmedia.discordapp.net%2Fattachments%2F966771498956234762%2F1225192480429969418%2F1000036245-removebg-preview.png%3Fex%3D66203c6a%26is%3D660dc76a%26hm%3Db2553f149fadead3b4430f98ff7b39cd2cc69944d93fc9dd9c2bf6ade6210fc1%26&w=1080&q=75
3	Notebook Galaxy Book4 Pro	Descrição do Galaxy Book4 Pro	5736.74	8	1	https://benchpromos.com.br/_next/image?url=https%3A%2F%2Fimages.samsung.com%2Fis%2Fimage%2Fsamsung%2Fp6pim%2Fbr%2Fnp940xgk-kg1br%2Fgallery%2Fbr-galaxy-book4-pro-14-inch-np940-np940xgk-kg1br-541201711%3F%24365_292_PNG%24&w=640&q=75
4	Lenovo LOQ I5 12450H RTX 3050 6GB	Descrição do Notebook Lenovo	4073.99	15	1	https://benchpromos.com.br/_next/image?url=https%3A%2F%2Fmedia.discordapp.net%2Fattachments%2F966771498956234762%2F1208109808641908786%2FcjpAEEEEAAAasA4WcVox4BBBBAwL0A4edhDSAAAIIIGAVIPysYtQjgAACCLgXIPzcj5AGEEAAAQSsAoSfVYx6BBBAAAH3AoSfxHSAAIIIICAVYDws4pRjwACCCDgXoDwcz9CGkAAAQQQsAoQflYx6hFAAAEE3AsQfu5HSAMIIIAAAlaBfwD5OigQ4lRxIAAAAABJRU5ErkJggg.png%3Fex%3D65e216ef%26is%3D65cfa1ef%26hm%3D2eb5d03cc3f8b2b82bca56da89565a61381631cfb830a72eb8dba6884b6b5040%26%3D%26format%3Dwebp%26quality%3Dlossless&w=750&q=75
\.


--
-- TOC entry 3440 (class 0 OID 49284)
-- Dependencies: 216
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarios (id, cpf, nome, email, senha, data_nascimento, telefone, tipo_usuario) FROM stdin;
1	12345678901	João da Silva	joao.silva@example.com	senha123	1990-01-01	999999999	cliente
2	98765432109	Maria Oliveira	maria.oliveira@example.com	senha456	1985-05-15	888888888	admin
\.


--
-- TOC entry 3468 (class 0 OID 0)
-- Dependencies: 221
-- Name: carrinhos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.carrinhos_id_seq', 2, true);


--
-- TOC entry 3469 (class 0 OID 0)
-- Dependencies: 217
-- Name: categorias_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categorias_id_seq', 1, true);


--
-- TOC entry 3470 (class 0 OID 0)
-- Dependencies: 223
-- Name: itens_carrinho_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.itens_carrinho_id_seq', 3, true);


--
-- TOC entry 3471 (class 0 OID 0)
-- Dependencies: 227
-- Name: itens_pedido_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.itens_pedido_id_seq', 2, true);


--
-- TOC entry 3472 (class 0 OID 0)
-- Dependencies: 229
-- Name: pagamentos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pagamentos_id_seq', 1, true);


--
-- TOC entry 3473 (class 0 OID 0)
-- Dependencies: 225
-- Name: pedidos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pedidos_id_seq', 2, true);


--
-- TOC entry 3474 (class 0 OID 0)
-- Dependencies: 219
-- Name: produtos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produtos_id_seq', 4, true);


--
-- TOC entry 3475 (class 0 OID 0)
-- Dependencies: 215
-- Name: usuarios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuarios_id_seq', 2, true);


--
-- TOC entry 3279 (class 2606 OID 49393)
-- Name: carrinhos carrinhos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carrinhos
    ADD CONSTRAINT carrinhos_pkey PRIMARY KEY (id);


--
-- TOC entry 3275 (class 2606 OID 49414)
-- Name: categorias categorias_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categorias
    ADD CONSTRAINT categorias_pkey PRIMARY KEY (id);


--
-- TOC entry 3281 (class 2606 OID 49426)
-- Name: itens_carrinho itens_carrinho_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itens_carrinho
    ADD CONSTRAINT itens_carrinho_pkey PRIMARY KEY (id);


--
-- TOC entry 3285 (class 2606 OID 49451)
-- Name: itens_pedido itens_pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itens_pedido
    ADD CONSTRAINT itens_pedido_pkey PRIMARY KEY (id);


--
-- TOC entry 3287 (class 2606 OID 49480)
-- Name: pagamentos pagamentos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamentos
    ADD CONSTRAINT pagamentos_pkey PRIMARY KEY (id);


--
-- TOC entry 3283 (class 2606 OID 49500)
-- Name: pedidos pedidos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedidos
    ADD CONSTRAINT pedidos_pkey PRIMARY KEY (id);


--
-- TOC entry 3277 (class 2606 OID 49530)
-- Name: produtos produtos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produtos
    ADD CONSTRAINT produtos_pkey PRIMARY KEY (id);


--
-- TOC entry 3269 (class 2606 OID 49293)
-- Name: usuarios usuarios_cpf_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_cpf_key UNIQUE (cpf);


--
-- TOC entry 3271 (class 2606 OID 49295)
-- Name: usuarios usuarios_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_email_key UNIQUE (email);


--
-- TOC entry 3273 (class 2606 OID 49566)
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);


--
-- TOC entry 3289 (class 2606 OID 49567)
-- Name: carrinhos carrinhos_usuario_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carrinhos
    ADD CONSTRAINT carrinhos_usuario_id_fkey FOREIGN KEY (usuario_id) REFERENCES public.usuarios(id);


--
-- TOC entry 3290 (class 2606 OID 49431)
-- Name: itens_carrinho itens_carrinho_carrinho_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itens_carrinho
    ADD CONSTRAINT itens_carrinho_carrinho_id_fkey FOREIGN KEY (carrinho_id) REFERENCES public.carrinhos(id);


--
-- TOC entry 3291 (class 2606 OID 49531)
-- Name: itens_carrinho itens_carrinho_produto_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itens_carrinho
    ADD CONSTRAINT itens_carrinho_produto_id_fkey FOREIGN KEY (produto_id) REFERENCES public.produtos(id);


--
-- TOC entry 3293 (class 2606 OID 49501)
-- Name: itens_pedido itens_pedido_pedido_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itens_pedido
    ADD CONSTRAINT itens_pedido_pedido_id_fkey FOREIGN KEY (pedido_id) REFERENCES public.pedidos(id);


--
-- TOC entry 3294 (class 2606 OID 49536)
-- Name: itens_pedido itens_pedido_produto_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.itens_pedido
    ADD CONSTRAINT itens_pedido_produto_id_fkey FOREIGN KEY (produto_id) REFERENCES public.produtos(id);


--
-- TOC entry 3295 (class 2606 OID 49506)
-- Name: pagamentos pagamentos_pedido_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamentos
    ADD CONSTRAINT pagamentos_pedido_id_fkey FOREIGN KEY (pedido_id) REFERENCES public.pedidos(id);


--
-- TOC entry 3292 (class 2606 OID 49572)
-- Name: pedidos pedidos_usuario_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedidos
    ADD CONSTRAINT pedidos_usuario_id_fkey FOREIGN KEY (usuario_id) REFERENCES public.usuarios(id);


--
-- TOC entry 3288 (class 2606 OID 49553)
-- Name: produtos produtos_categoria_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produtos
    ADD CONSTRAINT produtos_categoria_id_fkey FOREIGN KEY (categoria_id) REFERENCES public.categorias(id);


-- Completed on 2024-06-23 19:35:40 -04

--
-- PostgreSQL database dump complete
--

